package com.zxq.util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 记录存储：使用 List<Record> 存储所有的记账记录。
 * 添加记录：addRecord 方法允许用户添加一条新的记账记录，包括描述和金额。
 * 计算总金额：calculateTotal 方法遍历所有记录，计算出总金额。
 * 格式化金额：formatAmount 方法用于格式化金额为带有千位分隔符和小数点的字符串。
 * 显示所有记录：displayRecords 方法将所有的记账记录打印到控制台。
 * 主方法：main 方法示例如何使用这个 Utility 类进行简单的记账操作。
 * */
public class Utility {

    // 记录存储
    private List<Record> records = new ArrayList<>();

    // 添加记账记录
    public void addRecord(String description, double amount) {
        records.add(new Record(description, amount));
    }

    // 计算总金额
    public double calculateTotal() {
        double total = 0.0;
        for (Record record : records) {
            total += record.getAmount();
        }
        return total;
    }

    // 获取所有记录
    public List<Record> getRecords() {
        return records;
    }

    // 格式化金额
    public String formatAmount(double amount) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(amount);
    }

    // 内部类，用于表示记账记录
    class Record {
        private String description;
        private double amount;

        public Record(String description, double amount) {
            this.description = description;
            this.amount = amount;
        }

        public String getDescription() {
            return description;
        }

        public double getAmount() {
            return amount;
        }

        @Override
        public String toString() {
            return "Description: " + description + ", Amount: " + formatAmount(amount);
        }
    }

    // 显示所有记录
    public void displayRecords() {
        for (Record record : records) {
            System.out.println(record);
        }
    }

    public static void main(String[] args) {
        Utility utility = new Utility();
        utility.addRecord("Lunch", 12.50);
        utility.addRecord("Coffee", 4.75);
        utility.addRecord("Groceries", 23.10);

        System.out.println("All Records:");
        utility.displayRecords();

        double total = utility.calculateTotal();
        System.out.println("Total Amount: " + utility.formatAmount(total));
    }
}
