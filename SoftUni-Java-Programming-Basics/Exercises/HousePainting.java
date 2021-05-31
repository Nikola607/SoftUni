import java.util.Scanner;

public class HousePainting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double houseHeight= Double.parseDouble(scan.nextLine());
        double sideWall = Double.parseDouble(scan.nextLine());
       double sideRoofWallHeight = Double.parseDouble(scan.nextLine());
        // backWall area = houseHeight * houseHeight
        // front wall area = (1.2 * 2) - backWall
        // side wall area = (houseHeight * SideWall) - 1.5 * 1.5
        // both side walls = sideWallArea * sideWallArea
        //both front walls = frontWallArea + back wall area
        //all walls =  both side walls + both front walls
        //green paint = allWalls / 3.4
        //roof
        //side roof walls = houseHeight * SideWall
        //front roof wall = (houseHeight * sideRoofWallHeight) / 2
        //  all roof walls = frontRoofWall + (SideRoofWall * SideRoofWall)
        double backWallArea = houseHeight * houseHeight;
        double frontWallArea = backWallArea -(1.2 * 2);
        double sideWallArea = (houseHeight * sideWall ) - 1.5 * 1.5;
        double bothSideWalls = sideWallArea + sideWallArea;
        double bothFrontWalls = frontWallArea + backWallArea;
        double allWalls = bothFrontWalls + bothSideWalls;
        double greenPaint = allWalls / 3.4;

        double sideRoofWall = houseHeight * sideWall;
        double FrontRoofWall = (houseHeight * sideRoofWallHeight) / 2;
        double allRoofWalls = FrontRoofWall + FrontRoofWall + (sideRoofWall + sideRoofWall);
        double redPaint = allRoofWalls / 4.3;
        System.out.printf("%.02f", greenPaint);
        System.out.println();
        System.out.printf("%.02f", redPaint);


    }
}

