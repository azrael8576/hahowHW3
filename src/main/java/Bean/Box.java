package Bean;

/**
 * Created by AlexHe on 2019-02-12.
 * Describe
 */

public class Box {
    private String name;
    private float length;
    private float width;
    private float height;

    public Box(String name, float length, float width, float height) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public boolean validate(float length, float width, float height) {
        if (length > this.length) {
            if (length > this.height) {
                System.out.println("物品長寬過不符，請選其他箱子！");
                return false;
            }
        }
        else if (width > this.length) {
            if (width > this.height) {
                System.out.println("物品長寬不符，請選其他箱子！");
                return false;
            }
        }
        else if (height > this.height) {
            System.out.println("物品面積過高，請選其他箱子！");
            return false;
        }
        return true;
    }
}
