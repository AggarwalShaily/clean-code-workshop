package com.movierental;

class HtmlStatement {
  public String display(String name, Rentals rentals) {
    String result = "<h1>Rental Record for <b>" + name + "</b></h1><br/>";

    for (Rental each : rentals) {
      result += each.getMovie().getTitle() + each.amount() + "<br/>";
    }

    //add footer lines result
    result += "Amount owed is <b>" + rentals.totalAmount() + "</b><br/>";
    result += "You earned <b>" + rentals.totalFrequentRenterPoints()
            + "</b> frequent renter points";
    return result;
  }
}
