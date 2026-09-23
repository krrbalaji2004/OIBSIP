import random
import string

print("================================")
print("     RANDOM PASSWORD GENERATOR")
print("================================")

while True:

    try:
        length = int(input("\nEnter password length (minimum 8): "))

        if length < 8:
            print("Password length must be at least 8.")
            continue

        print("\nSelect password types:")
        print("1. Uppercase letters")
        print("2. Lowercase letters")
        print("3. Numbers")
        print("4. Symbols")

        choice = input("Enter choices (example: 1234): ")

        if len(choice) < 2:
            print("Please select at least 2 types.")
            continue

        characters = ""

        if "1" in choice:
            characters += string.ascii_uppercase

        if "2" in choice:
            characters += string.ascii_lowercase

        if "3" in choice:
            characters += string.digits

        if "4" in choice:
            characters += string.punctuation

        if characters == "":
            print("Invalid choice.")
            continue

        password = ""

        for i in range(length):
            password += random.choice(characters)

        print("\n================================")
        print("Generated Password:")
        print(password)
        print("================================")

        again = input("\nGenerate another password? (yes/no): ")

        if again.lower() != "yes":
            print("\nThank you!")
            break

    except ValueError:
        print("Please enter a valid number.")