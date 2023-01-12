# Comment with name, class, time, and PE1
# os allows us to clear the screen in a actual console or terminal
import os

accounts = {'9999': {'Name': 'Raymond', 'C': 1000.00, 'S': 1099.00}}

# Allow 3 invalid pin entries
tries = 1
maxTries = 3

while tries <= maxTries:
    # Print bank title and menu
    print(f'{"Cactus Bank":^30}\n')
    selection = input('Enter pin or x to exit application: ').casefold()

    # determine exit, pin not found, or correct pin found
    if selection == 'x':
        break
    elif selection not in accounts:
        # clear screen - cls for windows and clear for linux or os x
        os.system('clear')

        print(f'Invalid pin. Attempt {tries} of {maxTries}. Please Try again')
        if tries == maxTries:
            print('Locked out!  Exiting program')
        # increment tries
        tries += 1
    else:
        # Upgrade: successful pin entry. reset tries and save pin
        tries = 1
        pin = selection

        # clear screen
        os.system('clear')

        # Display Welcome <Customer Name>
        print(f'Welcome %s!' % accounts.get(pin).get('Name'))
        # accounts[pin] holds a dictionary where 'Name' is the key
        # to the customer's name value

        while True:
            try:
                selection = input('Enter C to make Checking transaction or S for Savings transaction: ').upper()
                if selection != 'C' and selection != 'S':
                    raise ValueError('Incorrect Selection. You must enter C or S.')
            except ValueError as ex:
                print(ex)
            else:
                os.system('clear')
                print(f'Opening {selection} account...\n')
            break
        balance = accounts.get(pin).get(selection)
        # Entry must be C or S to use as a key for the account balances
        # Use a loop and exception handling to ensure input is good
        # reuse selection name to store input to avoid scope issues

        # Upgrade: Removed slicing and w/d entry - New Instructions
        print('Transaction instructions:')
        print(' - Withdrawal enter a negative dollar amount: -20.00.')
        print(' - Deposit enter a positive dollar amount: 10.50')

        # Upgrade: removed for loop only 1 transaction per pin input

        # accounts is the new dictionary that needs to be indexed
        # using the entered pin and the selection account type
        print(f'\nBalance:  ${balance: .2f}')

        # Good input - convert to float and store in amount
        # Exception - Print Bad Amount and set amount to zero
        amount = float()
        try:
            amount = float(input(f'Enter transaction amount: '))
        except Exception:
            print('Bad Amount - No Transaction.')
            amount = 0
        # Upgrade: Verify enough funds in account
        # add indices for pin and selection holding account type

        if (amount + balance) >= 0:
            balance += amount
            accounts[pin][selection] = balance
            print(f'Transaction complete. New balance is ${balance: .2f}')
        else:
            print('Insufficient Funds. Transaction Cancelled.')

# end of application loop
