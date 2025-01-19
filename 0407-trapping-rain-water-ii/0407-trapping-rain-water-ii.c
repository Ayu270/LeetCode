typedef struct {
    int x, y, height;
} Cell;

typedef struct {
    Cell* data;
    int size, capacity;
} MinHeap;

MinHeap* createHeap(int capacity) {
    MinHeap* heap = (MinHeap*)malloc(sizeof(MinHeap));
    heap->data = (Cell*)malloc(capacity * sizeof(Cell));
    heap->size = 0;
    heap->capacity = capacity;
    return heap;
}

void swap(Cell* a, Cell* b) {
    Cell temp = *a;
    *a = *b;
    *b = temp;
}

void push(MinHeap* heap, Cell cell) {
    heap->data[heap->size++] = cell;
    int i = heap->size - 1;
    while (i > 0 && heap->data[i].height < heap->data[(i - 1) / 2].height) {
        swap(&heap->data[i], &heap->data[(i - 1) / 2]);
        i = (i - 1) / 2;
    }
}

Cell pop(MinHeap* heap) {
    Cell root = heap->data[0];
    heap->data[0] = heap->data[--heap->size];
    int i = 0;
    while (2 * i + 1 < heap->size) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < heap->size && heap->data[left].height < heap->data[smallest].height)
            smallest = left;
        if (right < heap->size && heap->data[right].height < heap->data[smallest].height)
            smallest = right;
        if (smallest == i)
            break;
        swap(&heap->data[i], &heap->data[smallest]);
        i = smallest;
    }
    return root;
}

bool isEmpty(MinHeap* heap) {
    return heap->size == 0;
}





int trapRainWater(int** heightMap, int heightMapSize, int* heightMapColSize) {
    if (heightMapSize <= 2 || heightMapColSize[0] <= 2)
        return 0;

    int m = heightMapSize, n = heightMapColSize[0];
    bool visited[m][n];
    memset(visited, 0, sizeof(visited));
    MinHeap* heap = createHeap(m * n);

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                push(heap, (Cell){i, j, heightMap[i][j]});
                visited[i][j] = true;
            }
        }
    }

    int directions[4][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int waterTrapped = 0;

    while (!isEmpty(heap)) {
        Cell current = pop(heap);
        for (int d = 0; d < 4; d++) {
            int nx = current.x + directions[d][0];
            int ny = current.y + directions[d][1];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                visited[nx][ny] = true;
                waterTrapped += fmax(0, current.height - heightMap[nx][ny]);
                push(heap, (Cell){nx, ny, fmax(current.height, heightMap[nx][ny])});
            }
        }
    }

    free(heap->data);
    free(heap);
    return waterTrapped;
}