#define MAX_SIZE 40000 

typedef struct {
    int prefix[MAX_SIZE];
    int size;  
} ProductOfNumbers;

ProductOfNumbers* productOfNumbersCreate() {
    ProductOfNumbers* obj = (ProductOfNumbers*)malloc(sizeof(ProductOfNumbers));
    obj->size = 0;
    obj->prefix[0] = 1;  
    return obj;
}

void productOfNumbersAdd(ProductOfNumbers* obj, int num) {
    if (num == 0) {
        obj->size = 0;  
        obj->prefix[0] = 1;
    } else {
        obj->size++;
        obj->prefix[obj->size] = obj->prefix[obj->size - 1] * num;
    }
}

int productOfNumbersGetProduct(ProductOfNumbers* obj, int k) {
    if (k > obj->size) return 0; 
    return obj->prefix[obj->size] / obj->prefix[obj->size - k];
}

void productOfNumbersFree(ProductOfNumbers* obj) {
    free(obj);
}


/**
 * Your ProductOfNumbers struct will be instantiated and called as such:
 * ProductOfNumbers* obj = productOfNumbersCreate();
 * productOfNumbersAdd(obj, num);
 
 * int param_2 = productOfNumbersGetProduct(obj, k);
 
 * productOfNumbersFree(obj);
*/