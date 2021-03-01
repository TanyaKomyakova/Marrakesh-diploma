package ru.netology.web.data;

import lombok.Value;

public class DataHelper {

    private DataHelper(){}

    @Value
    public static class CardInfo{
        private String validCard;
        private String invalidCard;
        private String validMonth;
        private String invalidMonth;
        private String wrongMonthFormat;
        private String validYear;
        private String invalidYear;
        private String invalidName;
        private String validName;
        private String code;
    }

    public static CardInfo getCard(){
        return new CardInfo("4444 4444 4444 4441","4444 4444 4444 4442", "11","01", "1","21", "20", "Vasya","Вася453","454");
    }


}
