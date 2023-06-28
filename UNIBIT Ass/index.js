function findCombinations(arr, target) {
    const complementDict = {};
    const result = [];
  
    // Find pairs that sum up to the target value
    for (let num of arr) {
      const complement = target - num;
      if (complement in complementDict) {
        for (let pair of complementDict[complement]) {
          result.push([pair, num]);
        }
      }
      complementDict[num] = complementDict[num] || [];
      complementDict[num].push(num);
    }
  
    // Merge arrays and sort in ascending order
    const mergedArray = result.reduce((acc, val) => acc.concat(val), []).sort((a, b) => a - b);
  
    // Double the target value
    target *= 2;
    const combinations = [];
  
    // Find combinations that sum up to the double of the target value
    for (let i = 0; i < mergedArray.length; i++) {
      for (let j = i + 1; j < mergedArray.length; j++) {
        if (mergedArray[i] + mergedArray[j] === target) {
          combinations.push([mergedArray[i], mergedArray[j]]);
        }
      }
    }
  
    return combinations;
  }
  
  const arr = [1, 3, 2, 2, -4, -6, -2, 8];
  const target = 4;
  
  const combinations = findCombinations(arr, target);
  
  console.log("First Combination For '4':", combinations);
  