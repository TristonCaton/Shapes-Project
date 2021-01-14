
/**
 * Draw a pretty picture composed of shape objects on a canvas
 * 
 * @author: (Triston Caton)
 * @version: (1-14-2020)
 * 
 */
import java.io.File;
import java.io.IOException;

public class Picture {
    public static void main(String[] args) {
        // Get a reference to the canvas for this drawing
        Canvas pic = Canvas.getCanvas();

        // Set the title and background for the picture
        pic.setTitle("Triston C - Midterm Project");
        pic.setBackgroundColor("white");

        // Draw my picture
	Rect Grass = new Rect();
	Grass.changeColor("green");
	Grass.moveHorizontal(-500);
	Grass.moveVertical(300);
	Grass.makeVisible();
	Grass.changeSize(500,1000);

	Rect House = new Rect();
	House.changeColor("brown");
	House.moveVertical(100);
	House.moveHorizontal(-100);
	House.changeSize(200);
	House.makeVisible();

	Triangle Roof = new Triangle();
	Roof.changeColor("black");
	Roof.changeSize(50, 200);
	Roof.moveVertical(30);
	Roof.moveHorizontal(100);
	Roof.makeVisible();

	int numShapes = 3;
	int i = 0;
	int offset = 0;
	Circle[] hay = new Circle[13];
	for(int x = 0; x <= 12; x++){ // Initializing all of the classes in the array
		hay[x] = new Circle();
		hay[x].changeSize(30);
		hay[x].changeColor("yellow");
	}
	
	int count = 0;
	while(numShapes <= 12){
		System.out.println(i);
		if(count % 3 == 0){
			offset += -30;
			count = 0;
		}
		hay[i].moveHorizontal(230+(count*30));
		hay[i].moveVertical(330+offset);
		hay[i].makeVisible();
		count++;
		i++;
		numShapes++;
	}
        // Get the filename to save to from the command line arguments, defaulting to
        // MyPicture.png if no argument is given
        String filename;
        if (args.length > 0 && args[0] != null && !args[0].isEmpty()) {
            filename = args[0];
        }
        else {
            filename = "MyPicture.png";
        }

        // Save the picture to a file
        try {
            pic.saveToFile(new File(filename));
            System.out.println("Picture saved to " + filename);
        } catch (IOException e) {
            System.err.println(e);
            System.err.println("Could not save file.");
        }
    }
}
