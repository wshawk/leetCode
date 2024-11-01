package leetcode.string;

/**
 * @author hawk
 * @package leetcode.string
 * @desc 1108. IP 地址无效化
 * 给你一个有效的 IPv4 地址address，返回这个 IP 地址的无效化版本。
 *
 * 所谓无效化IP 地址，其实就是用"[.]"代替了每个 "."。
 *
 *
 * 示例 1：
 *
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 * 示例 2：
 *
 * 输入：address = "255.100.50.0"
 * 输出："255[.]100[.]50[.]0"
 *
 *
 * 提示：
 *
 * 给出的address是一个有效的 IPv4 地址
 *
 * @date 2021/1/29
 */
public class DefangingAnIpAddress {
    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了19.28%的用户
     * 内存消耗：36.6 MB, 在所有 Java 提交中击败了40.58%的用户
     * @param address
     * @return
     */
    public String defangIPaddrV1(String address) {
        return address.replaceAll("\\.", "[\\.]");
    }
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.4 MB, 在所有 Java 提交中击败了74.17%的用户
     * @param address
     * @return
     */
    public String defangIPaddrV2(String address) {
        return address.replace(".", "[.]");
    }
}
