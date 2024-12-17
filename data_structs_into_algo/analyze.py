import re
import pandas as pd

import matplotlib.pyplot as plt
import seaborn as sns

with open("test.log", "r") as log_file:
    log_content = log_file.read()
    pattern = r"Test d-heap with d: (\d+) array size: (\d+) - comparisons: (\d+) assignments: (\d+)"
    matches = re.findall(pattern, log_content)

    df = pd.DataFrame(matches, columns=["d", "array_size", "comparisons", "assignments"])

df[["d", "array_size", "comparisons", "assignments"]] = df[["d", "array_size", "comparisons", "assignments"]].astype(int)

# Calculate dynamic limits
max_comparisons = df["comparisons"].max()
max_assignments = df["assignments"].max()

min_comparisons = df["comparisons"].min()
min_assignments = df["assignments"].min()

margin = 50  # Adjust margin as needed
print(max_assignments, max_comparisons)
# Visualization
fig, axes = plt.subplots(1, 2, figsize=(18, 8))

# Plot comparisons
sns.lineplot(ax=axes[0], data=df, x="array_size", y="comparisons", hue="d", marker="o", palette="tab10")
axes[0].set_title("Comparisons vs Array Size", fontsize=16)
axes[0].set_xlabel("Array Size", fontsize=14)
axes[0].set_ylabel("comparisons", fontsize=14)

axes[0].legend(title="d-Heap Value", fontsize=12)
axes[0].grid(True)
axes[0].set_ylim([min_comparisons - margin, max_comparisons + margin])

# Plot assignments
sns.lineplot(ax=axes[1], data=df, x="array_size", y="assignments", hue="d", marker="o", palette="tab10")
axes[1].set_title("Assignments vs Array Size", fontsize=16)
axes[1].set_xlabel("Array Size", fontsize=14)
axes[1].set_ylabel("assignments", fontsize=14)
axes[1].legend(title="d-Heap Value", fontsize=12)

axes[1].grid(True)
axes[1].set_ylim([min_assignments - margin, max_assignments + margin])

# Tight layout for better spacing
plt.tight_layout()
fig.savefig('analysis.png')
# plt.show()