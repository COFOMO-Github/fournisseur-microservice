package com.cofomo.microservice.fournisseur.utils;

import org.springframework.stereotype.Component;


@Component
public class Constants {

    /*********************
     *      PATH
     ***********************/

    public static final String FOURNISSEUR_URL = "/fournisseur";
    public static final String JSON_TEST_DATA_FILE_PATH="src/test/resources/cucumber/json_data/";

    /*******************
        TABLE NAME
     ********************/

    public static final String FOURNISSEUR = "FOURNISSEUR";


    /*********************
     * COLUMN NAME
     ***********************/

    public static final String ID = "ID";
    public static final String NAME = "NAME";
    public static final String REFERENCE = "REFERENCE";
    public static final String COUNTRY = "COUNTRY";

    /*********************
     * Messages Exceptions
     ***********************/

    public static final String MESSG_ERR = "No record of type %s and with id %s is present in the database";

}
