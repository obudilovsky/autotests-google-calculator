package com.autotests.google.calculator;

/**
 * Created by o.budilovsky on 19.03.2017.
 */

public class Variables {
    public static final String GOOGLE_URL = "https://google.com/search?hl=en";
    public static final String GOOGLE_TITLE = "//div[@title='Google']";
    public static final String GOOGLE_INPUT = "lst-ib";
    public static final String GOOGLE_CALCULATOR = "//span[@class='cwcot'][contains(text(), '0')]";
    public static final String CALCULATOR_PANEL = "//div[@class='cwtlotc']";
    public static final String CALCULATOR_INPUT = "//div[@id='cwtltblr']";
    public static final String CALCULATOR_SUM = "//span[@class='cwbts'][contains(text(), '+')]";
    public static final String CALCULATOR_MUL = "//span[@class='cwbts'][contains(text(), '×')]";
    public static final String CALCULATOR_DIV = "//span[@class='cwbts'][contains(text(), '÷')]";
    public static final String CALCULATOR_SQRRT = "//span[@class='cwbts cwbg1'][contains(text(), '√')]";
    public static final String CALCULATOR_EQU = "//span[@class='cwbts'][contains(text(), '=')]";
    public static final String CALCULATOR_INPUT_RESULT = "cwos";
    public static final String GOOGLE_NUMBER_RESULTS = "//div[@id='resultStats'][contains(text(), 'results')]";
}