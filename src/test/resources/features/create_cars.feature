Feature: creating cars to the fleet
  Car should be added to the fleet by providing valid information

  @dev
  Scenario Outline: Create and save cars
    Given User is in the login page
    Given As a user I log in to the application with username and password
    Given I hover over fleet and click on Vehicles
    Given I create a car with the following information:
      | LicensePlate      | <license_plate>       |
      | Tags              | <tags>                |
      | Driver            | <driver>              |
      | Location          | <location>            |
      | ModelYear         | <model_year>          |
      | LastOdometer      | <last_odometer>       |
      | FirstContractDate | <first_contract_date> |
      | Transmission      | <transmission>        |
      | FuelType          | <fuelType>            |
      | Logo              | <logo>                |
    Given I save and close
    Then I verify new car page is loaded with title contains  license plate "<license_plate> <driver>"

    Examples:
      | license_plate | tags    | driver     | location | model_year | last_odometer | first_contract_date | transmission | fuelType | logo                              |
      | 61TRZN        | sedan   | Kel oglan  | akcaabat | 2018       | 45678         | Dec 5, 2017         | Automatic    | Gasoline | C:\Users\rukal\Desktop\donkey.jpg |
      #| 29CNN         | compact | Kor Kaptan | Bayburt  | 2017       | 23999         | Feb 24, 2018        | Manual       | Diesel   | C:\Users\rukal\Desktop\cow.jpg    |
      #| 54TRZN        | junior  | kartal Goz | urfa     | 2000       | 4678          | Jun 8, 2017         | Automatic    | Gasoline | C:\Users\rukal\Desktop\donkey.jpg |
