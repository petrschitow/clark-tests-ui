@privathaftpflicht

Feature: Privathaftpflicht sales funnel check

  Scenario: Privathaftpflicht happy path
    Given I open 'Vertage' page
    When I click 'Angebote' link
    Then I see main title on the Angebote page
    When I click to 1-click-kauf 'Privathaftpflicht'
    Then I see title 'Angebot zur Privathaftpflicht'
    When I confirm the agreement
    And I click 'Angebot anfordern' button
    Then I see first question
    When I choose the first answer in the first question
    Then I see second question
    When I choose the first answer in the second question
    Then I see third question
    When I choose the first answer in the third question
    Then I see fourth question
    When I enter the text as an answer to the fourth question: "I don't have previous damages"
    And I click 'Angebot anfordern' button
    When I click 'Zum Angebot' button
    Then I see title 'Deine Angebote zur Privathaftpflicht'
    When I choose primary offer
    Then I see title 'Deinen Fortschritt sichern'
    When I put random email and password
    And I push Jetzzt Registrieren Button
    Then I see title 'Personliche Angaben'
    When I fill form with test data
    And I click 'Weiter' button
    Then I see main title 'Zahlungsdaten'
    When I put IBAN number = "DE55500105174529223988"
    And I click confirmation check-box
    And I click button 'Tarif bestellen'
    Then I see title 'Angaben-Übersicht'
    And I click confirmation check-box
    And I click 'Jetzt verbindlich kaufen' button
    Then I see title 'Bestellung abgeschlossen'
    When I click 'Zurück zur Übersicht' button
    Then I close popup
    And I see my application






