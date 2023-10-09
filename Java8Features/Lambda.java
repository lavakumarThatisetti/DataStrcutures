package Java8Features;

interface NumToMonth {
    public String convertToMonth(int x);
}

public class Lambda {

    // Driver code
    public static void main(String[] args)
    {

        // Lambda Expression
        NumToMonth obj =(n)->{
            String[] months = { "Jan", "Feb", "Mar",
                    "Apr", "May", "Jun",
                    "Jul", "Aug", "Sep",
                    "Oct", "Nov", "Dec" };
            return (n > 0 && n <= months.length)
                        ? months[n - 1]
                        : null;
        };
        System.out.println(obj.convertToMonth(8));
    }
}
