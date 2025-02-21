/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

#define HASH_SIZE 1000003

typedef struct {
    int* hashTable;
} FindElements;

int hash(int key) {
    return key % HASH_SIZE;
}

void insert(FindElements* obj, int value) {
    int index = hash(value);
    while (obj->hashTable[index] != -1) {
        index = (index + 1) % HASH_SIZE;
    }
    obj->hashTable[index] = value;
}

bool findElementsFind(FindElements* obj, int target) {
    int index = hash(target);
    while (obj->hashTable[index] != -1) {
        if (obj->hashTable[index] == target) {
            return true;
        }
        index = (index + 1) % HASH_SIZE;
    }
    return false;
}

void dfs(struct TreeNode* node, int value, FindElements* obj) {
    if (node == NULL) return;
    node->val = value;
    insert(obj, value);
    if (node->left) dfs(node->left, 2 * value + 1, obj);
    if (node->right) dfs(node->right, 2 * value + 2, obj);
}

FindElements* findElementsCreate(struct TreeNode* root) {
    FindElements* obj = (FindElements*)malloc(sizeof(FindElements));
    obj->hashTable = (int*)malloc(sizeof(int) * HASH_SIZE);
    for (int i = 0; i < HASH_SIZE; i++) {
        obj->hashTable[i] = -1;
    }
    if (root != NULL) {
        root->val = 0;
        insert(obj, 0);
        dfs(root, 0, obj);
    }
    return obj;
}

void findElementsFree(FindElements* obj) {
    if (obj != NULL) {
        free(obj->hashTable);
        free(obj);
    }
}


/**
 * Your FindElements struct will be instantiated and called as such:
 * FindElements* obj = findElementsCreate(root);
 * bool param_1 = findElementsFind(obj, target);
 
 * findElementsFree(obj);
*/
