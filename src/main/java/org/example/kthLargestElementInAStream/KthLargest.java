package org.example.kthLargestElementInAStream;

public class KthLargest {
    private int[] tree;

    private int m = 0;

    private int k = 0;

    public KthLargest(int k, int[] nums) {
        this.tree = new int[k];

        this.k = k;

        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                tree[i] = nums[i];

                int x = i;

                while (x > 0 && tree[x] < tree[(x - 1) / 2]) {
                    int temp = tree[x];
                    tree[x] = tree[(x - 1) / 2];
                    tree[(x - 1) / 2] = temp;
                    x = (x - 1) / 2;
                }

                m = i + 1;
            } else {
                if (nums[i] > tree[0]) {
                    tree[0] = nums[i];

                    int j = 0;

                    while (j < k) {
                        if (j * 2 + 2 < k) {
                            if (tree[j * 2 + 1] < tree[j * 2 + 2]) {
                                if (tree[j] > tree[j * 2 + 1]) {
                                    int temp = tree[j];
                                    tree[j] = tree[j * 2 + 1];
                                    tree[j * 2 + 1] = temp;
                                    j = j * 2 + 1;
                                } else {
                                    break;
                                }
                            } else {
                                if (tree[j] > tree[j * 2 + 2]) {
                                    int temp = tree[j];
                                    tree[j] = tree[j * 2 + 2];
                                    tree[j * 2 + 2] = temp;
                                    j = j * 2 + 2;
                                } else {
                                    break;
                                }
                            }
                        } else if (j * 2 + 1 < k) {
                            if (tree[j] > tree[j * 2 + 1]) {
                                int temp = tree[j];
                                tree[j] = tree[j * 2 + 1];
                                tree[j * 2 + 1] = temp;
                                j = j * 2 + 1;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }

    public int add(int val) {
        if (m == 0){
            tree[m] = val;

            m++;
        } else if(m < k) {
            tree[m] = val;

            int i = m;

            while (i > 0 && tree[i] < tree[(i - 1) / 2]) {
                int temp = tree[i];
                tree[i] = tree[(i - 1) / 2];
                tree[(i - 1) / 2] = temp;
                i = (i - 1) / 2;
            }

            m++;
        } else {
            if (val > tree[0]) {
                tree[0] = val;

                int j = 0;

                int k = tree.length;

                while (j < k) {
                    if (j * 2 + 2 < k) {
                        if (tree[j * 2 + 1] < tree[j * 2 + 2]) {
                            if (tree[j] > tree[j * 2 + 1]) {
                                int temp = tree[j];
                                tree[j] = tree[j * 2 + 1];
                                tree[j * 2 + 1] = temp;
                                j = j * 2 + 1;
                            } else {
                                break;
                            }
                        } else {
                            if (tree[j] > tree[j * 2 + 2]) {
                                int temp = tree[j];
                                tree[j] = tree[j * 2 + 2];
                                tree[j * 2 + 2] = temp;
                                j = j * 2 + 2;
                            } else {
                                break;
                            }
                        }
                    } else if (j * 2 + 1 < k) {
                        if (tree[j] > tree[j * 2 + 1]) {
                            int temp = tree[j];
                            tree[j] = tree[j * 2 + 1];
                            tree[j * 2 + 1] = temp;
                            j = j * 2 + 1;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }

        }

        return tree[0];
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{5, -1});
        System.out.println(kthLargest.add(2)); // returns 4
        System.out.println(kthLargest.add(1)); // returns 5
        System.out.println(kthLargest.add(-1)); // returns 5
        System.out.println(kthLargest.add(3)); // returns 8
        System.out.println(kthLargest.add(4)); // returns 8
    }
}
