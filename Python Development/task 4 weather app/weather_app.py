import requests

print("================================")
print("        WEATHER APP")
print("================================")

API_KEY = "abc123xyz456"

while True:

    city = input("\nEnter city name: ")

    if city.strip() == "":
        print("City name cannot be empty.")
        continue

    url = (
        "https://api.openweathermap.org/data/2.5/weather"
        "?q=" + city +
        "&appid=" + API_KEY +
        "&units=metric"
    )

    try:

        response = requests.get(url)

        data = response.json()

        if response.status_code == 200:

            temperature = data["main"]["temp"]
            humidity = data["main"]["humidity"]
            condition = data["weather"][0]["description"]
            wind_speed = data["wind"]["speed"]

            print("\n================================")
            print("          WEATHER RESULT")
            print("================================")

            print("City:", city)
            print("Temperature:", temperature, "°C")
            print("Humidity:", humidity, "%")
            print("Condition:", condition)
            print("Wind Speed:", wind_speed, "m/s")

            print("================================")

        elif response.status_code == 404:

            print("City not found.")

        elif response.status_code == 401:

            print("Invalid API key.")

        else:

            print("Unable to get weather information.")

    except requests.exceptions.ConnectionError:

        print("Network error. Please check your internet connection.")

    except Exception as e:

        print("Something went wrong:", e)

    again = input("\nSearch another city? (yes/no): ")

    if again.lower() != "yes":

        print("\nThank you for using Weather App!")
        break