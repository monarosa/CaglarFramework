Feature: creating cars to the fleet
  Car should be added to the fleet by providing valid information

  @dev
  Scenario Outline: Create and save cars
    Given As a user I log in to the application with username and password
    Given I hover over fleet and click on Vehicles
    Given I create a car a with following information:
      | LicensePlate    | Diver    | Location   | ModelYear    | LastOdometer    | FirstContractDate     | Transmission   | FuelType   | Logo   |
      | <license_plate> | <driver> | <location> | <model_year> | <last_odometer> | <first_contract_date> | <transmission> | <fuelType> | <logo> |
    Given I save and close
    Then I verify car is added for driver "<driver>" with license plate "<license_plate>"

    Examples:
      | license_plate | driver    | location | model_year | last_odometer | first_contract_date | transmission | fuelType | logo   |
      | tzk134        | can demir | el paso  |       2018 |         95909 | Dec 5, 2017         | Manuel       | Gasoline | donkey |

