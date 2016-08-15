    package solutions;


    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.math.BigInteger;
    import java.util.Arrays;

    public class CubicsRube {
        public static void main(String[] args) {
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
                int dimensionsSize = Integer.parseInt(reader.readLine());
                Integer[][][] cube = new Integer[dimensionsSize][dimensionsSize][dimensionsSize];
                String input;
                while (!(input = reader.readLine()).equals("Analyze")) {
                    Integer [] bombardingDetails = Arrays
                            .stream(input.split(" "))
                            .map(Integer::parseInt)
                            .toArray(Integer[]::new);
                    int particle = bombardingDetails[3];
                    int x = bombardingDetails[0];
                    int y = bombardingDetails[1];
                    int z = bombardingDetails[2];
                    boolean xIsInCube = x >=0 && x < dimensionsSize;
                    boolean yIsInCube = y >=0 && y < dimensionsSize;
                    boolean zIsInCube = z >=0 && z < dimensionsSize;
                    boolean xIsAtItsEdge = x==0 || x == dimensionsSize-1;
                    boolean yIsAtItsEdge = y==0 || y == dimensionsSize-1;
                    boolean zIsAtItsEdge = z==0 || z == dimensionsSize-1;
                    boolean xAndYAreAtEdge = xIsAtItsEdge && yIsAtItsEdge;
                    boolean yAndZAreAtEdge = yIsAtItsEdge && zIsAtItsEdge;
                    boolean xAndZAreAtEdge = xIsAtItsEdge && zIsAtItsEdge;
                    if (xIsInCube && yIsInCube && zIsInCube){
                        if (!(xIsAtItsEdge || yIsAtItsEdge || zIsAtItsEdge))
                            cube[x][y][z] = particle;
                    }
                }

                BigInteger[] resultToPrint = getSumOfTheNumbersInCubeAndBombedCellsCount(cube, dimensionsSize);
                System.out.println(resultToPrint[0]);
                BigInteger nonBombedCellsCount = BigInteger.valueOf(dimensionsSize*dimensionsSize*dimensionsSize).subtract(resultToPrint[1]);
                System.out.println(nonBombedCellsCount);

            }catch (IOException ex){

            }
        }

        private static BigInteger[] getSumOfTheNumbersInCubeAndBombedCellsCount(Integer [][][] cube, int n){
            BigInteger[] result = {BigInteger.valueOf(0), BigInteger.valueOf(0)};

            for (int x = 0; x <cube.length; x++) {
                for (int y = 0; y < cube[x].length; y++) {
                    for (int z = 0; z < cube[x][y].length; z++) {
                        Integer cellValue = cube[x][y][z];
                        if (cellValue != null){
                            result[1] = result[1].add(BigInteger.valueOf(1));
                            result[0] = result[0].add(BigInteger.valueOf(cellValue));
                        }
                    }
                }
            }

            return result;
        }
    }
