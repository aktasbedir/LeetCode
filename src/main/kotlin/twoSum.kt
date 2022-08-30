import java.io.BufferedReader
import java.io.File

private const val FILE_PATH = "/Users/bedir/Documents/dev/leetCode/leetcode-kotlin-solutions/src/main/kotlin/input.txt"


/*
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1]
*/


fun main() {
    val bufferedReader: BufferedReader = File(FILE_PATH).bufferedReader()
    val inputString = bufferedReader.use { it.readLines() }
    val nums = inputString[0].removeSurrounding("[", "]").split(",").map { it.toInt() }.toTypedArray()
    val target = inputString[1].toInt()
    val result = twoSum(nums, target)
    val result2 = twoSumHash(nums.toIntArray(), target).toTypedArray()
    println(result.contentToString())
    println(result2.contentToString())
}

/* ==> Brute Force => time complexity : O(n^2) ,Space Complexity : O(1) çünkü the space does not depend pn the size of the array, only constant space is used */
fun twoSum(nums: Array<Int>, target: Int): IntArray {
    for (i in nums.indices) { //i in 0 until nums.size
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] == target) {
                return intArrayOf(i, j)
            }
        }
    }
    throw IllegalArgumentException("No solution")
}

/* ==> Hash Table => time complexity : O(n) , Space Complexity : O(n) çünkü  The extra space required depends on the number of items stored in the hash table, which stores at most n elements. */
fun twoSumHash(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()
    nums.forEachIndexed { idx, item ->
        val found = map[target - item]
        found?.let {
            return intArrayOf(found, idx)
        }
        map[item] = idx
    }
    throw IllegalArgumentException("No solution")
}
