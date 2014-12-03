/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package images;

import javafx.scene.image.Image;

/**
 *
 * @author Melanie
 */
public class ImageSelector
{
    public Image getImage(String objectName)
    {
        Image image = null;
        String url = "";
        
        if (objectName == "character")
        {
            url = "player.png";
        }
        
        image = new Image(this.getClass().getResourceAsStream(url));
        return image;
    }
}
