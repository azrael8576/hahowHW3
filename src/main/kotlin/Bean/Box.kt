package bean.kotlin
/**
 * Created by AlexHe on 2019-02-12.
 * Describe
 */

open class Box(val name : String, val length : Float, val width : Float, val height : Float) {
    fun validate(length: Float, width: Float, height: Float): Boolean {
        if (length > this.length) {
            if (length > this.height) {
                println("物品長寬過不符，請選其他箱子！")
                return false
            }
        } else if (width > this.length) {
            if (width > this.height) {
                println("物品長寬不符，請選其他箱子！")
                return false
            }
        } else if (height > this.height) {
            println("物品面積過高，請選其他箱子！")
            return false
        }
        return true
    }
}