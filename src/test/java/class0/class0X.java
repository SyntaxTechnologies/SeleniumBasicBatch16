package class0;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class class0X {



        @Test
        public void deckOfCardsAPITest() {

            // Confirm the site is up
            RestAssured.baseURI = "https://deckofcardsapi.com";
            Response response = RestAssured.given().when().get("/api/deck/new");
            Assert.assertEquals(response.getStatusCode(), 200, "Site is not up.");
//
            System.out.println(response.getStatusCode());
            // Get a new deck and shuffle it
            response = RestAssured.given().when().get("/api/deck/new/shuffle/?deck_count=1");
            Assert.assertEquals(response.getStatusCode(), 200, "Failed to get new deck and shuffle.");
            String deck_id = response.getBody().jsonPath().getString("deck_id");
//
            System.out.println(deck_id);
            // Deal three cards to each of two players
            Response playerOneResponse = RestAssured.given().when().get("/api/deck/" + deck_id + "/draw/?count=3");
            Response playerTwoResponse = RestAssured.given().when().get("/api/deck/" + deck_id + "/draw/?count=3");
            Assert.assertEquals(playerOneResponse.getStatusCode(), 200, "Failed to deal three cards to player one.");
            Assert.assertEquals(playerTwoResponse.getStatusCode(), 200, "Failed to deal three cards to player two.");

            // Check whether either player has blackjack
            boolean playerOneHasBlackjack = checkBlackjack(playerOneResponse);
            boolean playerTwoHasBlackjack = checkBlackjack(playerTwoResponse);


            // If either has, write out which one does
            if (playerOneHasBlackjack) {
                System.out.println("Player one has blackjack.");
            }
            if (playerTwoHasBlackjack) {
                System.out.println("Player two has blackjack.");
            }
            if(!playerTwoHasBlackjack && !playerOneHasBlackjack){
                System.out.println(" no Player has blackjack.");
            }
        }


            private boolean checkBlackjack(Response response) {
                List<String> cards = response.jsonPath().getList("cards.value");
                int totalValue = 0;
                boolean hasAce = false;

                for (String card: cards) {
                    if (card.equalsIgnoreCase("KING") || card.equalsIgnoreCase("QUEEN") || card.equalsIgnoreCase("JACK")) {
                        totalValue += 10;
                    } else if (card.equalsIgnoreCase("ACE")) {
                        hasAce = true;
                    } else {
                        totalValue += Integer.parseInt(card);
                    }
                }

                if (hasAce && totalValue <= 10) {
                    totalValue += 11;
                } else if (hasAce) {
                    totalValue += 1;
                }

                return totalValue == 21;
            }

        }
