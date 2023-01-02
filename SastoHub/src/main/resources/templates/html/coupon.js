let products = [{
    name: "Product 1",
    actualPrice: 1000,
    salePrice: 1000,
    couponApplied: false,
},
{
    name: "Product 2",
    actualPrice: 2000,
    salePrice: 1900,
    couponApplied: true,
},
{
    name: "Product 3",
    actualPrice: 2000,
    salePrice: 2000,
    couponApplied: false,
},
{
    name: "Product 4",
    actualPrice: 2000,
    salePrice: 2000,
    couponApplied: false,
},
];

const coupon = [{
    code: "p10",
    discountPrice: 100,
    applicableProducts: ["Product 1", "Product 2"],
},
{
    code: "p20",
    discountPrice: 200,
    applicableProducts: ["Product 3", "Product 4"],
},
];