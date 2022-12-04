import java.util.Scanner;

public class DepositCalculator {
        double calculateComplexPercen( double oneDate, double twoDate,int index ) {
           double pay = oneDate * Math.pow(( 1 + twoDate / 12 ), 12 * index);
           return roundMath(pay, 2);
        }

        double calculateSimplePercent(double aMmount,double yearRate, int periodDeposit) {
             return roundMath(aMmount + aMmount * yearRate * periodDeposit, 2);
        }
        double roundMath(double value, int places) {
            double ScaLe = Math.pow(10, places);
            return Math.round( value * ScaLe ) / ScaLe;
        }

        void jobImport( ) {
            int period;
            int action;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите сумму вклада в рублях:");
            int amount = scanner.nextInt();
            System.out.println("Введите срок вклада в годах:");
            period = scanner.nextInt();
            System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
            action = scanner.nextInt();
            double outVariable = 0;
            if (action == 1) {
                outVariable = calculateSimplePercent(amount, 0.06, period);
            } else {
                if (action == 2) {
                    outVariable = calculateComplexPercen(amount, 0.06, period);
                }
                System.out.println("Результат вклада: " + amount + " за " + period +
                        " лет превратятся в " + outVariable);
            }
        }

        public static void main(String[] args) {
            new DepositCalculator().jobImport();
        }

}
