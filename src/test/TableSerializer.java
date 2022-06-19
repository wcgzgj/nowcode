package test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.tools.jconsole.Tab;

import java.util.*;

/**
 * @ClassName TableSeralizer
 * @Description TODO
 * @Author faro_z
 * @Date 2022/6/6 17:08
 * @Version 1.0
 **/
public class TableSerializer {

    public static void main(String[] args) {
        List<Address> addresses = new ArrayList<>();
        addresses.addAll(Arrays.asList(new Address("1", "北京市", 1, "0",new ArrayList<>()),
                new Address("2", "朝阳区", 2, "1",new ArrayList<>()),
                new Address("3", "望京街道", 3, "2",new ArrayList<>()),
                new Address("4", "海淀区", 2, "1",new ArrayList<>())));
        TableSerializer serializer = new TableSerializer();
        List<Address> serializedAddresses = serializer.serialize(addresses);
        //Gson
    }

    public List<Address> serialize(List<Address> addresses) {
        HashMap<String, List<Address>> idMap = new HashMap<>();
        ArrayList<Address> res = new ArrayList<>();
        for (Address address : addresses) {
            idMap.putIfAbsent(address.getPid(), new ArrayList<>());
            idMap.get(address.getPid()).add(address);
        }
        res.addAll(idMap.get("0"));
        for (Address address : addresses) {
            address.children.addAll(Optional
                    .ofNullable(idMap.get(address.getId()))
                    .orElseGet(()->new ArrayList<>()));
        }
        return res;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Address {
        private String id;
        private String name;
        private Integer level;
        private String pid;
        private List<Address> children;
    }
}
