Product xmlProduct = new Product(
                                element.getElementsByTagName("name").item(0).getTextContent(),
                                element.getElementsByTagName("description").item(0).getTextContent(),
                                Integer.parseInt(element.getElementsByTagName("quantity").item(0).getTextContent()),
                                Double.parseDouble(element.getElementsByTagName("retailPrice").item(0).getTextContent()),
                                Double.parseDouble(element.getElementsByTagName("storePrice").item(0).getTextContent())
                            );