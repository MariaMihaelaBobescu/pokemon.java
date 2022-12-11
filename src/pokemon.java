public class pokemon {

    @Getter
    @Setter
    @NoArgsConstructor
    @ToString






    public class Pokemon {

        private int id;

        private String name;

        private String mainPower;

        private String type;

        public Pokemon(String name, String mainPower, String type) {
            this.name = name;
            this.mainPower = mainPower;
            this.type = type;
        }

        private static list;pokemon:
        private static List<Pokemon> getPokemons() {
            //Trebuie creata lista in care vom salva pokemonii
            List<Pokemon> pokemons = new ArrayList<>();

            //Declaram query-ul ce va fi executat de catre DB
            String selectQuery = "SELECT * FROM pokemon";

            //Ne conectam la DB (try-catch -> TBD)
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement statement = connection.createStatement()) {

                //Cel ce va retine rezultatul query-ului
                ResultSet resultSet = statement.executeQuery(selectQuery);

                //Verificam daca in resultSet avem rezultate
                while (resultSet.next()) {
                    //Mapam fiecare linie la obiectul Pokemon din Java
                    Pokemon pokemon = new Pokemon();
                    pokemon.setId(resultSet.getInt(1));
                    pokemon.setName(resultSet.getString(2));
                    pokemon.setMainPower(resultSet.getString(3));
                    pokemon.setType(resultSet.getString(4));

                    //Adaugam obiectul obtinut de pe fiecare linie in lista
                    pokemons.add(pokemon);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            //la final va trebui sa returnam lista
            //pokemonilor din DB
            return pokemons;
        }



    }




}
