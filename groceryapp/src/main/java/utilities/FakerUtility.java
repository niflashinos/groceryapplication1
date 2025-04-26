package utilities;

import com.github.javafaker.Faker;

public class FakerUtility {

	Faker faker = new Faker();

	public String generateName() {

		return faker.name().fullName();

	}

	public String generateFirstName() {

		return faker.name().firstName();

	}

	public String generateBloodGroup() {

		return faker.name().bloodGroup();

	}

	public String generateLastName() {

		return faker.name().lastName();

	}

	public String generatePhone() {

		return faker.phoneNumber().phoneNumber();
	}

	public String generateLandLineNumber() {

		return faker.phoneNumber().cellPhone();
	}

	public String generateEmailAddress() {
		return faker.internet().emailAddress();
	}

	public String generateAddress() {
		return faker.address().fullAddress();

	}

	public String generateCity() {
		return faker.address().buildingNumber();

	}

	public String generateCountry() {

		return faker.address().country();

	}

	public String generateCountryCode() {

		return faker.address().countryCode();

	}

	public String generateCityName() {

		return faker.address().cityName();
	}

	public String generateStreetAddress() {

		return faker.address().streetAddress();
	}

	public String generateSecondaryAddress() {

		return faker.address().secondaryAddress();
	}

	public String generateRandomDigits(int count) {
		Faker faker = new Faker();
		return faker.number().digits(count);
	}
}
