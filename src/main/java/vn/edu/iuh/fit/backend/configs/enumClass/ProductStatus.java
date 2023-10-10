package vn.edu.iuh.fit.backend.configs.enumClass;

public enum ProductStatus {
    INACTIVE(0),
    ACTIVE(1),

    TERMINATED(-1);
    private final int value;
    ProductStatus(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    // Phương thức tùy chỉnh để chuyển đổi giá trị số nguyên thành enum ProductStatus
    public static ProductStatus fromValue(int value) {
        for (ProductStatus status : ProductStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status value: " + value);
    }

}
