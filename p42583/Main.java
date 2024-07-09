package p42583;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        // 아래 변수에 대한 값은 문제에서 제시한 값을 대입한 것입니다.
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};

        int count = 0;
        int currentWeight = 0;

        Queue<Integer> bridge = new LinkedList<>();

        for (int truck : truck_weights) {
            while (true) {
                if (bridge.isEmpty()) {
                    bridge.offer(truck);
                    currentWeight += truck;
                    count++;
                    break;
                } else if (bridge.size() == bridge_length) {
                    currentWeight -= bridge.poll();
                } else {
                    if (currentWeight + truck <= weight) {
                        bridge.offer(truck);
                        currentWeight += truck;
                        count++;
                        break;
                    } else {
                        bridge.offer(0);
                        count++;
                    }
                }
            }
        }
        count += bridge_length;

        // 올바른 시간이 출력되는 지 확인을 위한 print문 입니다.
        System.out.println(count);
    }
}
