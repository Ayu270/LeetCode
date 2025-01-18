typedef struct {
    int x, y, cost;
} Node;

typedef struct {
    Node* data;
    int front, rear, size, capacity;
} Deque;

Deque* createDeque(int capacity) {                                    // Function to initialize deque
    Deque* deque = (Deque*)malloc(sizeof(Deque));
    deque->data = (Node*)malloc(capacity * sizeof(Node));
    deque->front = 0;
    deque->rear = -1;
    deque->size = 0;
    deque->capacity = capacity;
    return deque;
}

bool isEmpty(Deque* deque) {
    return deque->size == 0;
}

void pushFront(Deque* deque, Node value) {
    deque->front = (deque->front - 1 + deque->capacity) % deque->capacity;
    deque->data[deque->front] = value;
    deque->size++;
}

void pushBack(Deque* deque, Node value) {
    deque->rear = (deque->rear + 1) % deque->capacity;
    deque->data[deque->rear] = value;
    deque->size++;
}

Node popFront(Deque* deque) {
    Node value = deque->data[deque->front];
    deque->front = (deque->front + 1) % deque->capacity;
    deque->size--;
    return value;
}

int directions[4][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};      // Directions: right, left, down, up


int minCost(int** grid, int gridSize, int* gridColSize) {
    int m = gridSize, n = gridColSize[0];
    int cost[m][n];
    memset(cost, 0x3f, sizeof(cost));
    cost[0][0] = 0;

    Deque* deque = createDeque(m * n);
    pushFront(deque, (Node){0, 0, 0});

    while (!isEmpty(deque)) {
        Node current = popFront(deque);
        int x = current.x, y = current.y, currentCost = current.cost;

        if (cost[x][y] < currentCost) continue;

        for (int i = 0; i < 4; i++) {
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

            int newCost = currentCost + (grid[x][y] != (i + 1));
            if (newCost < cost[nx][ny]) {
                cost[nx][ny] = newCost;
                if (grid[x][y] == (i + 1)) {
                    pushFront(deque, (Node){nx, ny, newCost});
                } else {
                    pushBack(deque, (Node){nx, ny, newCost});
                }
            }
        }
    }

    free(deque->data);
    free(deque);
    return cost[m - 1][n - 1];
}