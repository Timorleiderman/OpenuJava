package unit_6;

public class SalariesStatistics {

    public static final int MONTHS = 12;
    public static int [][] salaries = {
        {10500, 10300, 11000, 10600, 10500, 10500, 10600, 10300, 10800, 10600, 10900, 11000},
        {9000, 9500, 9500, 10600, 10000, 10500, 10600, 10600, 10800, 10000, 10100, 10200},
        {9900, 9800, 9850, 9900, 10000, 10500, 10600, 10600, 10800, 10000, 10100, 10200},
        {10000, 10300, 11000, 10600, 10000, 10500, 10600, 11000, 10800, 10000, 10500, 10150}
    };
    public static String [] names = {"Yossi", "Danna", "Moshe", "Galit"};

    public static void main(String[] args) {

    }

    public int bestSalary(String name) {
        int idx = indexOf(name);
        if (idx< 0)
            return idx;

        int maxSall = salaries[idx][0];
        for (int i=1; i < salaries[idx].length; i++){
            if (salaries[idx][i] > maxSall)
                maxSall = salaries[idx][i];
        }
        return maxSall;
    }

    public String maxInMonth(int month) {

        int idxMax = 0;
        for (int i=1; i<salaries.length; i++) {
            if (salaries[idxMax][month] > salaries[i][month]) {
                idxMax = i;
            }
        }
        return names[idxMax];
    }

    private int indexOf(String name) {
        for (int idx = 0; idx < names.length; idx++) {
            if (name.equals(names[idx]))
                return idx;
        }
        return -1;
    }

    public double avrByMonth(int month) {

        double avgMonth = 0;
        for (int i=0; i<salaries.length; i++) {
            avgMonth += salaries[i][month];
        }
        return avgMonth / salaries.length;
    }

    public int bestMonth() {

        int maxMonth = 0;
        double maxAvg = avrByMonth(maxMonth);
        double curAvg;
        
        for (int i=1; i < salaries[0].length; i++) {
            curAvg = avrByMonth(i);
            if (curAvg > maxAvg) {
                maxAvg = curAvg;
                maxMonth = i;
            }
        }
        return maxMonth;
    }

    public String bestWorker() {

        int bestSal = salaries[0][0];
        int bestIdx = 0;

        for (int row=0; row < salaries.length; row++) {
            for (int col =0; col < salaries[0].length; col++) {
                if (bestSal< salaries[row][col]) {
                    bestSal = salaries[row][col];
                    bestIdx = row;
                }
            }
        }
        return names[bestIdx];
    }

}

