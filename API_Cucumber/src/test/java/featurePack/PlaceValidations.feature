Feature: Validation Place API.
 
@AddPlace   
  Scenario Outline: Verify that place is successfuly Added by using Add_Place_API
   Given Add Place PlayLoad "<name>","<language>","<address>","<phoneNumber>"
   When user calls "add_Place_API" with "Post" HTTP request
   Then API returned success response status cosde 200
   And "status" Code returned "OK"
   And "scope" Code returned "APP"
   And verify that place_id which I created and maps to "<name>" using "get_Place_API"
   
   Examples:
    |name		|language	 |address	|phoneNumber|
    |Manavi	|English1     |Noida51	|9331245555 |   
    
    
@DeletePlace      
Scenario: Verify Delete Place Id function
    Given Delete PlaceId with placePayLoad_body
    When user calls "delete_Place_API" with "Post" HTTP request 
    Then API returned success response status cosde 200
    And "status" Code returned "OK"