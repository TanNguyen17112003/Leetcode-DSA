class MyHashMap {

    private static final int BASE = 769;
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[BASE];
    }

    private int hash(int key) {
        return key % BASE;
    }

    private static class Node {
        int key, value;
        Node next;

        Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node head = buckets[index];
        Node cur = head;

        // Nếu đã tồn tại key thì cập nhật giá trị
        while (cur != null) {
            if (cur.key == key) {
                cur.value = value;
                return;
            }
            cur = cur.next;
        }

        // Thêm node mới vào đầu danh sách liên kết
        buckets[index] = new Node(key, value, head);
    }

    public int get(int key) {
        int index = hash(key);
        Node cur = buckets[index];

        while (cur != null) {
            if (cur.key == key) {
                return cur.value;
            }
            cur = cur.next;
        }

        return -1; // Không tìm thấy
    }

    public void remove(int key) {
        int index = hash(key);
        Node cur = buckets[index];
        Node prev = null;

        while (cur != null) {
            if (cur.key == key) {
                if (prev == null) {
                    buckets[index] = cur.next; // Xoá node đầu
                } else {
                    prev.next = cur.next; // Bỏ qua node hiện tại
                }
                return;
            }
            prev = cur;
            cur = cur.next;
        }
    }
}
