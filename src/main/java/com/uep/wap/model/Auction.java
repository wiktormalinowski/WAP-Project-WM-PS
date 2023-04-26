package com.uep.wap.model;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Auction {
    int calculateHoursBetweenDates(Date startDate, Date endDate) {
        long diff = endDate.getTime() - startDate.getTime();
        return (int) TimeUnit.HOURS.convert(diff, TimeUnit.MILLISECONDS);
    }
}
