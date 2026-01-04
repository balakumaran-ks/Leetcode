/**
 * @param {number[]} nums
 * @return {number}
 */
var sumFourDivisors = function(nums) {
    let res = 0;
    let temp = [];
    for(const num of nums){
        for(let i=1;i<=num/2;i++){
            if(num%i==0){
                temp.push(i);
            }
            if(temp.length>4) break;
        }
        temp.push(num);
        if(temp.length==4){
            for(let n of temp)
            res+=n;
        }
        temp = [];
    }
    return res;
};