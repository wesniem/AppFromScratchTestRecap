package nyc.c4q.wesniemarcelin.appfromscratchtestrecap.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by wesniemarcelin on 1/3/17.
 */


    public class Animal {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("textColor")
        @Expose
        private String textColor;
        @SerializedName("background")
        @Expose
        private String background;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTextColor() {
            return textColor;
        }

        public void setTextColor(String textColor) {
            this.textColor = textColor;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

    }
