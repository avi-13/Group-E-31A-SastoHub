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

    @NotEmpty(message = "enter the namme ")
    private String itemName;

    @NotEmpty(message = "plz select your quantity")
    private String itemQuantity;
    
}
