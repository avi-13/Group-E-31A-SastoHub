package com.system.sastohub.pojo;


                import jakarta.validation.constraints.NotEmpty;
                import lombok.AllArgsConstructor;
                import lombok.Getter;
                import lombok.NoArgsConstructor;
                import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CartPojo {

    private Integer id;

    @NotEmpty(message = "Full name can't be empty")
    private String itemName;

    @NotEmpty(message = "Mobile Number can't be empty")
    private String itemQuantity;
}
