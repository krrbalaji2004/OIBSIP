print("================================")
print("        BMI CALCULATOR")
print("================================")

while True:

    try:
        name = input("\nEnter your name: ")

        if name.strip() == "":
            print("Name cannot be empty.")
            continue

        weight = float(input("Enter your weight (kg): "))
        height = float(input("Enter your height (m): "))

        if weight <= 0:
            print("Weight must be greater than 0.")
            continue

        if height <= 0:
            print("Height must be greater than 0.")
            continue

        # BMI calculation
        bmi = weight / (height ** 2)

        # BMI classification
        if bmi < 18.5:
            category = "Underweight"

        elif bmi < 25:
            category = "Normal"

        elif bmi < 30:
            category = "Overweight"

        else:
            category = "Obese"

        print("\n================================")
        print("          BMI RESULT")
        print("================================")

        print("Name:", name)
        print("Weight:", weight, "kg")
        print("Height:", height, "m")
        print("BMI:", round(bmi, 2))
        print("Category:", category)

        print("================================")

        again = input("\nDo you want to calculate again? (yes/no): ")

        if again.lower() != "yes":
            print("\nThank you for using BMI Calculator!")
            break

    except ValueError:
        print("\nPlease enter numbers only for weight and height.")