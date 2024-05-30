export interface FileSaverPlugin {
  saveToDownloads(options: {
    url: string;
    fileName: string;
  }): Promise<{ downloadId: number }>;

  stopDownload(options: { id: number }): Promise<void>;
}
