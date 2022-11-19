
/** UML Class Diagram: class Rectangle
            
                    Rectangle     
-----------------------------------------------                                                        
-length: double                                
-width: double
-----------------------------------------------                                  
+Rectangle()                                      
+Rectangle(newWidth: double, newHeight: double)  
+getArea(): double                               
+getPerimeter(): double                          
+print(): void      
-----------------------------------------------                             
*/

public class Rectangle {
	double width;	
	double height;
	   Rectangle() {
		   width = 1;
		   height = 1;
	} 
	   Rectangle(double newWidth, double newHeight) {
		   width = newWidth;
		   height = newHeight;
	}
	   double getArea() {
		   return width * height; 
	}
	   double getPerimeter() {
		   return 2 * (width + height);
	}
}