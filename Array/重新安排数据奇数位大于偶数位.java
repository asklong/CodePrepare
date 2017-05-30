//quick select + reorder O(N)
//这题O(n)找中位数吧，然后大于中位数的放奇数位，小于的放偶数位
//2 3 4 6 7 9 10, if we have odd numbers, we place the median 6 in the last place, and rearrange the other arrays.
//if the array is 2 3 4 6 7 9, we have even numbers, we rearrange the number directly.
//we check the element, if the odd place element is smaller, the even place is larger than median.
//we find the 2 elements for swap.
