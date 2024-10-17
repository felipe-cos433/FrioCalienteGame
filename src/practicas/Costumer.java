package practicas;

    import java.util.Scanner;

    public class Costumer {

        Scanner sc = new Scanner(System.in);

        // ATRIBUTOS
        int userID;
        String userName;
        String userLastName;
        String userPhone;
        String userMail;
        String userPassword;
        String costumerType;
        int costumerPoints;

        // PRODUCTOS

        int productID;
        String productName;
        String productDesc;
        double cost;
        double price;
        int quantity;
        String state;


        // COMPORTAMIENTOS

        Object[][] costumers = new Object[5][8]; // Matriz para clientes.
        Object[][] products = new Object[5][7]; // Matriz para Productos.

        public Object createUser() {

            Object[] costumer = new Object[8];

            System.out.println("Ingresa el ID del Usuario");
            userID = sc.nextInt();
            costumer[0] = userID;
            sc.nextLine();
            System.out.println("Ingresa tu nombre");
            userName = sc.nextLine();
            costumer[1] = userName;
            System.out.println("Ingresa tu Apellido");
            userLastName = sc.nextLine();
            costumer[2] = userLastName;
            System.out.println("Ingresa tu Telefono");
            userPhone = sc.nextLine();
            costumer[3] = userPhone;
            System.out.println("Ingresa tu correo");
            userMail = sc.nextLine();
            costumer[4] = userMail;
            System.out.println("Crea tu Contraseña");
            userPassword = sc.nextLine();
            costumer[5] = userPassword;
            System.out.println("Ingrese el Tipo");
            costumerType = sc.nextLine();
            costumer[6] = costumerType;
            System.out.println("Ingresa tus puntos iniciales");
            costumerPoints = sc.nextInt();
            costumer[7] = costumerPoints;
            sc.nextLine();

            return costumer;

        }

        public void agregateCostumer() {

            for (int i = 0; i < costumers.length; i++) {
                costumers[i] = (Object[]) createUser();
            }
        }

        public void listUser() {

            for (int i = 0; i < costumers.length; i++) {
                Object[] costumer = (Object[]) createUser();
                System.out.println(costumer[i]);
            }
        }


        public void listUsers() {

            for (int i = 0; i < costumers.length; i++) {
                for (int j = 0; j < costumers[i].length; j++) {
                    System.out.println(costumers[i][j]);
                }
            }

        }

        public void updateUser() {

        }

        public void deleteUser() {

        }

}
