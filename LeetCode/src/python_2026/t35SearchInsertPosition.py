from random import randint
from typing import List




def main():
    print(searchInsert([1,3,5,6], 5))
    print(searchInsert([1,3,5,6], 2))
    print(searchInsert([1, 3, 5, 6], 7))

def searchInsert(nums: List[int], target: int) -> int:
    for(i, n) in enumerate(nums):
        if n == target:
            return i
        if n > target:
            return i
    return len(nums)


if __name__ == '__main__':
    main()