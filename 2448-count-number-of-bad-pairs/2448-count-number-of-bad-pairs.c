typedef struct HashNode {
    int key;
    int value;
    struct HashNode* next;
} HashNode;

typedef struct {
    HashNode** table;
    int size;
} HashMap;

int hash(int key, int size) {
    return (key % size + size) % size;
}

void insert(HashMap* map, int key, int* count) {
    int index = hash(key, map->size);
    HashNode* node = map->table[index];

    while (node) {
        if (node->key == key) {
            *count = node->value;
            node->value++;
            return;
        }
        node = node->next;
    }
    HashNode* newNode = (HashNode*)malloc(sizeof(HashNode));
    newNode->key = key;
    newNode->value = 1;
    newNode->next = map->table[index];
    map->table[index] = newNode;
    *count = 0;
}

void freeHashMap(HashMap* map) {
    for (int i = 0; i < map->size; i++) {
        HashNode* node = map->table[i];
        while (node) {
            HashNode* temp = node;
            node = node->next;
            free(temp);
        }
    }
    free(map->table);
}

long long countBadPairs(int* nums, int numsSize) {
    long long tp = (long long)numsSize * (numsSize - 1) / 2;
    long long gp = 0;
    HashMap map;
    map.size = 100003;
    map.table = (HashNode**)calloc(map.size, sizeof(HashNode*));

    for (int i = 0; i < numsSize; i++) {
        int diff = nums[i] - i;
        int count;
        insert(&map, diff, &count);
        gp += count;
    }
    freeHashMap(&map);
    return tp - gp;
}