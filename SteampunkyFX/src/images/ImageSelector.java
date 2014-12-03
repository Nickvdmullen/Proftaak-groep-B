/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package images;

import classes.Ballista;
import classes.Character;
import classes.Object;
import classes.Obstacle;
import classes.PowerUp;
import classes.Projectile;
import javafx.scene.image.Image;

/**
 *
 * @author Melanie
 */
public class ImageSelector
{
    public Image getImage(Object object, int level)
    {
        Image image = null;
        String url = "";
        
        if (object instanceof Ballista)
        {
            url = "ballista.png";
        }
        else if (object instanceof Character)
        {
            url = "player.png";
        }
        else if (object instanceof Obstacle)
        {
            if (object.getType().equals("box"))
            {      
                url = "obstacle.png";
            }
            else if (object.getType().equals("cube"))
            {
                switch (level)
                {
                    case 1:
                        url = "box01.png";
                        break;
                    case 2:
                        url = "box02.png";
                        break;
                    case 3:
                        url = "box03.png";
                        break;
                }
            }
        }
        else if (object instanceof PowerUp)
        {            
            switch (object.getType())
            {
                case "runspeed":
                    url = "powerup01.png";
                    break;
                case "torch":
                    url = "powerup02.png";
                    break;
                case "shield":
                    url = "powerup03.png";
                    break;
                case "projectile":
                    url = "powerup05.png";
                    break;
            }
        }
        else if (object instanceof Projectile)
        {
            url = "arrow.png";
        }
        
        image = new Image(this.getClass().getResourceAsStream(url));
        return image;
    }
}
