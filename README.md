# Fibabanka Speed Bootcamp Project
## Spring Boot Application

This project consists of 3 modules for ecommerce operations.

**Summary**

Commerce module works as a gateway, inventory and shopping modules work as service.

- Commerce --> Port: 8080
- Inventory --> Port: 8081
- Shopping --> Port: 8082

```
GET    /commerce/inventory/categories - retrieves the categories
GET    /commerce/inventory/products/{categoryId} - retrieves the products by the specified category
GET    /commerce/inventory/{productId} - retrieves the specified product
GET    /commerce/shopping/cart/create - retrieves the id of the created cart
POST   /commerce/cart/add - retrieves the body of the added product
DELETE /commerce/shopping/cart/{cartId}/remove/{productId} - removes the specified product from the specified cart
PUT    /commerce/shopping/checkout/{cartId} - retrieves the checkout message
GET    /commerce/shopping/find/{id} - retrieves the specified cart
```

**Api Documentations**

In order to get Api documentations of each module, you may use swagger-ui with their port.<br/>
`http://localhost:${PORT}/swagger-ui.html`
